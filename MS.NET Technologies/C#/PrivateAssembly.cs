using System;

namespace PrivateAssembly{
	
	public class Calculator{
		
		public void Addition (int x,int y){
			
			Console.WriteLine("Sum is:"+(x+y));
		}
		
		protected void Substract(int x,int y){
			
			Console.WriteLine("Difference is:"+(x-y));
		}
		
		protected internal void Multiply(int x,int y){
			
			Console.WriteLine("Multiplication is:"+(x*y));
		}
	}
}