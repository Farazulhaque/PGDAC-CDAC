using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.LinqExp
{
    internal class HashTableDemo
    {
        static void Main(string[] args)
        {
            Hashtable persons = new Hashtable();
            persons.Add("Arisha", 8240772401);
            persons.Add("Faraz", 7596885401);
            persons.Add("Kashaf", 6876548510);
            persons.Add("Saem", 5857654210);
            persons.Add("Parwez", 4867543210);
            persons.Add("Imran", 3876453210);
            persons.Add("Halah", 2876452310);
            //persons.Add(null, null); // key cannot be null, generate exception
            //persons.Add("Arisha", null); // duplicate key not allowed, generate exception


            Console.WriteLine("Persons data using foreach and DictionaryEntry : ");
            foreach (DictionaryEntry person in persons)
            {
                Console.WriteLine(person.Key + " \t: " + person.Value);
            }

            Console.WriteLine("\nPersons data using Iterator: ");
            IDictionaryEnumerator iterator = persons.GetEnumerator();
            while (iterator.MoveNext())
            {
                Console.WriteLine(iterator.Key + " \t: " + iterator.Value);
            }

            Console.WriteLine("\nPersons data getting only keys(names): ");
            //getting keys
            ICollection names = persons.Keys; // like list
            //foreach (string name in names)
            //    Console.WriteLine(name);

            IEnumerator keys = names.GetEnumerator();
            while (keys.MoveNext())
            {
                Console.WriteLine(keys.Current);
            }
        }
    }
}
