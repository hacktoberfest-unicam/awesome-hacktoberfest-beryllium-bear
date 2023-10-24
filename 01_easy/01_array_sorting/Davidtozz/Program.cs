using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;

//TEST: Pass in 5 4 2 1 as arguments from the CLI
//Run with "dotnet run 5 4 2 1" in the directory of the source file

namespace Easy01
{
    class Program
    {
        static void ThreadStart(object item)
        {
            Thread.Sleep(1000 * (int)item);
            Console.WriteLine(item);
        }

        static void SleepSort(IEnumerable<int> items)
        {
            foreach (var item in items)
            {
                new Thread(ThreadStart).Start(item);
            }
        }

        static void Main(string[] arguments)
        {
            SleepSort(arguments.Select(int.Parse));
        }
    }    
}
