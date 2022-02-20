using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day7
{
    //Implementation of IComparable Interface

    //class Product : IComparable<Product>
    class Product
    {
        // data fields
        int _PId;
        string _Name;
        float _Price;
        string _Brand;
        // properties
        public int PId { get => _PId; set => _PId = value; }
        public string Name { get => _Name; set => _Name = value; }
        public float Price { get => _Price; set => _Price = value; }
        public string Brand { get => _Brand; set => _Brand = value; }

        //public int CompareTo(Product other)
        //{
        //    //return this._PId.CompareTo(other._PId); // ascending
        //    //return -(this._PId.CompareTo(other._PId)); // descending
        //    return other._PId.CompareTo(this._PId); // descending
        //}

        // overriding ToString Method to display
        public override string ToString()
        {
            return $"ID: {_PId}\tName: {_Name}\tBrand: {_Brand}\tPrice: {_Price}";
        }
    }
    class SortByNameComparer : IComparer<Product>
    {
        // Access data fields using properties
        public int Compare(Product x, Product y)
        {
            return x.Name.CompareTo(y.Name);
        }
    }
    class SortByPriceComparer : IComparer
    {
        bool sortBy;
        public SortByPriceComparer(bool sortBy = false)
        {
            this.sortBy = sortBy;
        }
        // Access data fields using properties
        public int Compare(dynamic x, dynamic y)
        {
            if (!sortBy)
                return x.Price.CompareTo(y.Price);
            else
                return y.Price.CompareTo(x.Price);
        }

        // older syntax
        //public int Compare(object x, object y)
        //{
        //    return ((Product)x).Price.CompareTo(((Product)y).Price);
        //}
    }
    enum SortBy
    {
        //0, 1, 2, 3
        ID, Name, Price, Brand
    }
    class CompareBy : IComparer<Product>
    {
        bool _IsDesc;
        SortBy _SortBy;
        public CompareBy(SortBy _SortBy = SortBy.ID, bool _IsDesc = false)
        {
            this._SortBy = _SortBy;
            this._IsDesc = _IsDesc;
        }
        public int Compare(Product x, Product y)
        {
            int result = 0;
            switch (_SortBy)
            {
                case SortBy.ID:
                    if (!_IsDesc)
                        result = x.PId.CompareTo(y.PId);
                    else
                        result = y.PId.CompareTo(x.PId);
                    break;
                case SortBy.Name:
                    if (!_IsDesc)
                        result = x.Name.CompareTo(y.Name);
                    else
                        result = y.Name.CompareTo(x.Name);
                    break;
                case SortBy.Price:
                    if (!_IsDesc)
                        result = x.Price.CompareTo(y.Price);
                    else
                        result = y.Price.CompareTo(x.Price);
                    break;
                case SortBy.Brand:
                    if (!_IsDesc)
                        result = x.Brand.CompareTo(y.Brand);
                    else
                        result = y.Brand.CompareTo(x.Brand);
                    break;
                default:
                    break;
            }
            return result;
        }
    }
    internal class ArrayDemo4
    {
        static void Main(string[] args)
        {
            Product[] products = new Product[]
            {
                new Product()
                {
                    PId = 106,
                    Name ="Soap",
                    Brand ="Dettol",
                    Price =20.0f
                },
                new Product()
                {
                    PId = 102,
                    Name ="Mobile",
                    Brand ="Apple",
                    Price =50000.0f
                },
                new Product()
                {
                    PId = 101,
                    Name ="Laptop",
                    Brand ="Apple",
                    Price =2000000.0f
                },
                new Product()
                {
                    PId = 103,
                    Name ="Biscuit",
                    Brand ="Parle-G",
                    Price =10.0f
                },
                new Product()
                {
                    PId = 104,
                    Name ="Laptop",
                    Brand ="Hp",
                    Price =80000.0f
                }
            };
            Console.WriteLine("Product Details");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }
            /*
            Array.Sort(products); // sort data by Id
            Console.WriteLine("Sorted Product Details by Id");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }
            Array.Sort(products, new SortByNameComparer()); // sort data by name
            Console.WriteLine("Sorted Product Details by Name");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }

            Array.Sort(products, new SortByPriceComparer()); // sort data by price
            Console.WriteLine("Sorted Product Details by Price (Ascending order)");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }

            Array.Sort(products, new SortByPriceComparer(true)); // sort data by price
            Console.WriteLine("Sorted Product Details by Price (Descending order)");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }
            */


            Array.Sort(products, new CompareBy());
            Console.WriteLine("\nSorted Product Details by Id (Ascending order)");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }

            Array.Sort(products, new CompareBy(_IsDesc: true));
            Console.WriteLine("\nSorted Product Details by Id (Descending order)");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }

            Array.Sort(products, new CompareBy(SortBy.Name));
            Console.WriteLine("\nSorted Product Details by Name (Ascending order)");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }

            Array.Sort(products, new CompareBy(SortBy.Name, true));
            Console.WriteLine("\nSorted Product Details by Name (Descending order)");
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }

        }
    }
}
