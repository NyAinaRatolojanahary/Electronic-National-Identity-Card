using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using tany.Models;

namespace tany.Controllers
{
    [ApiController]
    [Route("api")]
    public class TanyWs : ControllerBase
    {
        [HttpGet("listsTanyCin")]
        public List<Tany> ListsTanyCin(String cin)
        {
            Tany t = new Tany();
            List<Tany> tanyList = new List<Tany>();
            tanyList = t.listeTanyParCin(cin);
            return tanyList;
        }


        [HttpGet("BornesTanyById")]
        public List<Borne> getBorneTany(int idtany)
        {
            Borne b = new Borne();
            List<Borne> borneList = new List<Borne>();
            borneList = b.getBorneParIdTany(idtany);
            return borneList;
        }

        [HttpPost("AddTany")]
        public ActionResult<string> AddTany(string nom,string cin)
        {
            string s = "ok";
            try
            {
                Tany tany = new Tany();
                tany.AddTany(nom, cin);
                Console.WriteLine("ok");
                return Ok(s);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex}");
            }
        }

        [HttpPost("AddBorne")]
        public ActionResult<string> AddBorne(string idtany,string longit,string lat)
        {
            string s = "ok";
            try
            {
                Borne br = new Borne();
                br.AddBornes(idtany,longit, lat);
                Console.WriteLine("ok");
                return Ok(s);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex}");
            }
        }


    }



}