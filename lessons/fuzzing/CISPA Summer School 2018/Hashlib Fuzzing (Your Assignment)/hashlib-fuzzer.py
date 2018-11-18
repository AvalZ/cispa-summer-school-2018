#!/usr/bin/env python3
# See https://docs.python.org/3/library/hashlib.html

# This program is copyright (c) 2017 Saarland University.
# Written by Andreas Zeller <zeller@cs.uni-saarland.de>.
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.

import random
import hashlib

hashlib_grammar = {
    "$START":
        ["$PREFIX$ASSIGN$HASHLIBVER$UPDATE$DIGEST$HEXDIGEST$PRINT",
            "$PREFIX$ASSIGN$MAC$BINASCII$PRINT",
            "$PREFIX$ASSIGN$HASHLIBCALL.hexdigest()\n$PRINT"],
        
    "$PREFIX":
        ["import hashlib, binascii\n"],

    "$MAC":
        ["dk = hashlib.pbkdf2_hmac('$HMACVER', b'$STRING', b'$STRING', $INTEGER)\n"],
    "$BINASCII":
        ["h = binascii.hexlify(dk)\n"],

    "$HASHLIBCALL":
        ["h = hashlib.$VER(x.encode('utf-8'))"],

    "$HASHLIBVER":
        ["m = hashlib.$VER()\n", "m = hashlib.new('$HMACVER')\n"],

    "$VER":
        ["sha256", "sha224" ],

    "$HMACVER":
        ["$VER", "ripemd160"],

    "$EXPANDEDVER":
        ["$HMACVER", "blake2b", "blake2s"],
    
    "$UPDATE":
        ["", "m.update(x.encode('utf-8'))\n"],

    "$DIGEST":
        ["h = m.digest()\n"],

    "$HEXDIGEST":
        ["h = m.hexdigest()\n"],

    "$ASSIGN":
        ['x = "$STRING"\n'],

    "$STRING":
        ["$LETTER$LETTER$LETTER$LETTER$LETTER$LETTER$LETTER",
            "$STRING$LETTER$LETTER$LETTER$LETTER$LETTER$LETTER" ],

    "$LETTER":
        ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
         "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"],

    "$PRINT":
        ["print(h)\n"],

    "$INTEGER":
        [
            # "$INTEGER$DIGIT",    -- THIS NUMBER IS TOO HIGH
            "$NONZERO$DIGIT$DIGIT$DIGIT",
            "$NONZERO"],

    "$DIGIT":
        ['0', "$NONZERO"],
    "$NONZERO":
        ['1', '2', '3', '4', '5', '6', '7', '8', '9'],

}



def apply_rule(term, rule):
    (old, new) = rule
    # We replace the first occurrence; 
    # this could also be some random occurrence
    # print(old,new)
    return term.replace(old, new, 1)

MAX_SYMBOLS = 100
MAX_TRIES = 500

def produce(grammar, term = "$START"):
    tries = 0

    while term.count('$') > 0:
        # All rules have the same chance;
        # this could also be weighted
        key = random.choice(list(grammar.keys()))
        repl = random.choice(grammar[key])
        new_term = apply_rule(term, (key, repl))
        if new_term != term and new_term.count('$') < MAX_SYMBOLS:
            term = new_term
            # print(term)
            tries = 0
        else:
            tries += 1
            if tries >= MAX_TRIES:
                assert False, "Cannot expand " + term
            
    return term
        
if __name__ == "__main__":
    for i in range(100):
        pgm = produce(hashlib_grammar)
        print(pgm)
        exec(pgm)
