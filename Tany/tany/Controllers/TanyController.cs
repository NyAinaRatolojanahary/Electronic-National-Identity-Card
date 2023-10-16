using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using tany.Models;

namespace tany.Controllers
{
    [Route("[controller]")]
    public class TanyController : Controller
    {
        private readonly ILogger<TanyController> _logger;

        public TanyController(ILogger<TanyController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index(string cin)
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View("Error!");
        }
    }
}