#!/usr/bin/env python3
# Grammar-based Fuzzing

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

term_grammar = {
    "$START":
        ["$EXPR"],

    "$EXPR":
        ["$EXPR + $TERM", "$EXPR - $TERM", "$TERM"],
    
    "$TERM":
        ["$TERM * $FACTOR", "$TERM / $FACTOR", "$FACTOR"],
    
    "$FACTOR":
        ["+$FACTOR", "-$FACTOR", "($EXPR)", "$INTEGER", "$INTEGER.$INTEGER"],

    "$INTEGER":
        ["$INTEGER$DIGIT", "$DIGIT"],

    "$DIGIT":
        ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
}

json_grammar = {
    "$START":
        ["$VALUE"],

    "$VALUE":
        ["$JSONOBJECT", "$ARRAY", "$STRING", "true", "false", "null", "$NUMBER"],
        
    "$STRING": 
        ['"$CHARACTERS"'],
        
    "$CHARACTERS":
        ["$ACHARACTER$CHARACTERS", "$ACHARACTER"],
    
    "$ACHARACTER":
        ["$LETTER", "$DIGIT", " "],
        
    "$LETTER":
        ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
         "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"],
    
    "$JSONOBJECT":
        ["{$FIELDS}"],
        
    "$FIELDS":
        ["$AFIELD, $FIELDS", "$AFIELD"],
        
    "$AFIELD":
        ["$STRING: $VALUE"],
        
    "$ARRAY":
        ["[$ELEMENTS]"],
        
    "$ELEMENTS":
        ["$VALUE, $ELEMENTS", "$VALUE"],
        
    "$NUMBER":
        ["-$INTEGER", "$INTEGER.$INTEGER", "$INTEGER"],

    "$INTEGER":
        ["$DIGIT$INTEGER", "$DIGIT"],

    "$DIGIT":
        ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
}

html_grammar = {
    "$START":
        ["$DOCUMENT"],
    
    "$DOCUMENT":
        ["$DOCTYPE$HTML"],

    "$DOCTYPE":
        ['<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"\n' + \
         '"http://www.w3.org/TR/html4/strict.dtd">\n'],

    "$HTML":
        ["<HTML>$HEAD$BODY</HTML>\n"],

    "$HEAD":
        ["<HEAD>$TITLE</HEAD>\n"],
        
    "$TITLE":
        ["<TITLE>A generated document</TITLE>\n"],

    "$BODY":
        ["<BODY>$DIVS</BODY>\n"],

    "$DIVS":
        ["$A_DIV", "$A_DIV\n$DIVS"],

    "$A_DIV":
        ["$A_HEADER\n$LIST"],

    "$A_HEADER":
        ["<H1>A header.</H1>", "<H1>Another header.</H1>"],

    "$LIST": 
        ["<UL>$ITEMS</UL>", "<OL>$ITEMS</OL>"],
    
    "$ITEMS":
        ["$AN_ITEM", "$AN_ITEM$ITEMS"],
    
    "$AN_ITEM":
        ["<LI>$TEXT</LI>\n"],

    "$TEXT":
        ["An item", "Another item"]
}


def apply_rule(term, rule):
    (old, new) = rule
    # We replace the first occurrence; 
    # this could also be some random occurrence
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
        print(produce(json_grammar, "$JSONOBJECT"))
        