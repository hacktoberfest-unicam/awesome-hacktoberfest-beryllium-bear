using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlockChain {
    public class Chain {

        private const string START = "start";
        private List<Block> catena;

        public Chain() {
            catena = new List<Block>();
        }

        public int GetLastHash() {
            if(catena.Count == 0) 
                return START.GetHashCode();
            return catena[catena.Count-1].GetHashCode();
        }

        public bool AddNewBlock(string block) {
            return AddNewBlock(new Block(block, GetLastHash()));
        }

        public bool AddNewBlock(Block block) {
            if (block.hashPrecedente == GetLastHash()) {
                catena.Add(block);
                return true;
            }
            return false;
        }

        public int GetSize() {
            return this.catena.Count;
        }

        public string? GetAt(int i) {
            if (i < 0 || i >= this.catena.Count)
                return null;
            return this.catena[i].stringaAttuale;
        }

    }
}
