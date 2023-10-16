using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using tany.Models;

namespace tany.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class TanyWs : ControllerBase
    {
        [HttpGet]
        [Route("listsTanyCin/{cin}")]
        public List<Tany> ListsTanyCin(String cin)
        {
            Tany t = new Tany();
            List<Tany> tanyList = new List<Tany>();
            tanyList = t.listeTanyParCin(cin);
            return tanyList;
        }
    }


}