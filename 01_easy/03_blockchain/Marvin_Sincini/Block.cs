using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlockChain {
    public class Block {

        public string stringaAttuale { get; init; }
        public int hashPrecedente { get; init; }

        public Block(string stringaAttuale, int hashPrecedente ) {
            this.stringaAttuale = stringaAttuale;
            this.hashPrecedente = hashPrecedente;
        }

        public override int GetHashCode() {
            return stringaAttuale.GetHashCode();
        }

        public string GetValue(int hash) {
            return hash == hashPrecedente ? stringaAttuale: "";
        }

        public string GetValue(string stringa) {
            return GetValue(stringa.GetHashCode());
        }

    }
}
