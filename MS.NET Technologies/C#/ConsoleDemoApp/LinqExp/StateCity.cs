using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.LinqExp
{
    internal class StateCity
    {
        class State
        {
            public int Id { get; set; }
            public string StateName { get; set; }
        }
        class City
        {
            public int Id { get; set; }
            public int CityStateId { get; set; }
            public string CityName { get; set; }
        }
        static void Main(string[] args)
        {
            IList<City> cities = new List<City>()
            {
               new City() {Id=1,CityStateId=1,CityName="Agra"},
               new City(){Id=2,CityStateId=1,CityName="Lucknow"},
               new City(){Id=8,CityStateId=2,CityName="Bhopal"},
               new City(){Id=4,CityStateId=2,CityName="Satna"},
               new City(){Id=5,CityStateId=3,CityName="Patna"},
               new City() {Id=6,CityStateId=3,CityName="Gaya"},
            };

            IList<State> states = new List<State>()
            {
                new State(){Id=1,StateName="UP"},
                new State(){Id=2,StateName="MP"},
                new State(){Id=3,StateName="Bihar"}
            };


            var city = from c in cities
                       select c;
            foreach (var c in city)
                Console.WriteLine($"ID: {c.Id}\tState ID: {c.CityStateId}\tCity Name: {c.CityName}");

            Console.WriteLine("\n---------------------------------------");
            //deferred execution
            //var city = from c in cities
            //           where c.CityStateId == 3
            //           select c;

            //immediate execution
            //var city = cities.Where(c => c.CityStateId == 3).ToList();

            //var city = from c in cities
            //           where c.CityStateId == 3
            //           select new { c.Id, c.CityName }; //anonymous type

            //var city = cities.Skip(3); //skip top 3 values
            //var city = cities.OrderBy(c => c.Id) // sort the data by ID
            //    .SkipWhile(c => c.Id <= 5); /// skip id values less than equal to 5 from beginning
            //var city = cities.Take(4); // take 4 values from top
            //var city = cities.TakeWhile(c => c.Id < 8);

            //var city = cities.First(c => c.Id < 8); // get only first data where condition satisfied

            //var city = cities.Single(c => c.Id == 8); // Single() function is used when only 1 record is getting e.g in primary key comparison

            //var city = cities.FirstOrDefault(c => c.Id < 8); // if there is chance of not getting any value
            //if (city != null)
            //    Console.WriteLine($"ID: {city.Id}\tState ID: {city.CityStateId}\tCity Name: {city.CityName}");
            //else
            //    Console.WriteLine("No City Found");


            // using Lambda Expression
            Func<City, bool> FindByState = (s) => s.CityStateId == 1;
            city = from c in cities
                   where FindByState(c)
                   select c;
            Console.WriteLine("Cities are: ");
            foreach (var c in city)
                //Console.WriteLine($"ID: {c.Id}\tState ID: {c.CityStateId}\tCity Name: {c.CityName}");
                Console.WriteLine($"ID: {c.Id}\tCity Name: {c.CityName}");

            Console.WriteLine("\n---------------------------------------");

            // using groupby operator
            var stategroup = from c in cities
                             group c by c.CityStateId;

            foreach (var state in stategroup)
            {
                Console.WriteLine(state.Key + " => ");
                foreach (var c in state)
                    Console.WriteLine($"\t{c.Id} => {c.CityStateId} => {c.CityName}");
            }
            Console.WriteLine("\n---------------------------------------");

            // Join operation
            var citi = from s in states
                       join c in cities
                       on s.Id equals c.CityStateId
                       select new { c.Id, c.CityName, s.StateName, SID = s.Id }; // SID=alias of states
            Console.WriteLine("City Data");
            foreach (var c in citi)
                Console.WriteLine($"ID: {c.Id}\tCity Name: {c.CityName}\tState ID: {c.SID}\tState Name: {c.StateName}");
            Console.WriteLine("\n---------------------------------------");
        }

    }
}
