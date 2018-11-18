#!/usr/bin/env python3
# Author: Rahul Gopinath <rahul.gopinath@cispa.saarland>
# License: GPLv3
# A simple PEG parser. Does not include *,+,? matches

import sys
import functools
import re

json_grammar = {
    "$START":
        ["$VALUE"],

    "$VALUE":
        ["$JSONOBJECT", "$ARRAY", "$STRING", "true", "false", "null", "$NUMBER"],
        
    "$STRING": 
        ['"$CHARACTERS"'],
        
    "$CHARACTERS":
        ["$CHARACTER$CHARACTERS", "$CHARACTER"],
    
    "$CHARACTER":
        ["$LETTER", "$DIGIT", " "],
        
    "$LETTER":
        ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
         "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"],
    
    "$JSONOBJECT":
        ["{$FIELDS}"],
        
    "$FIELDS":
        ["$FIELD, $FIELDS", "$FIELD"],
        
    "$FIELD":
        ["$STRING: $VALUE"],
        
    "$ARRAY":
        ["[$ELEMENTS]"],
        
    "$ELEMENTS":
        ["$VALUE, $ELEMENTS", "$VALUE"],
        
    "$NUMBER":
        ["+$FACTOR", "-$FACTOR", "$INTEGER.$INTEGER", "$INTEGER"],

    "$INTEGER":
        ["$DIGIT$INTEGER", "$DIGIT"],

    "$DIGIT":
        ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
}

RE_NONTERMINAL = re.compile(r'(\$[a-zA-Z_]*)')

class PEGParser:
    def __init__(self, grammar):
        def split(rule): return tuple(s for s in re.split(RE_NONTERMINAL, rule) if s)
        self.grammar = {k:[split(l) for l in rules] for k,rules in grammar.items()}

    def literal_match(self, part, text, cursor):
        return (cursor + len(part), (part, [])) if text[cursor:].startswith(part) else (cursor, None)

    # memoize repeated calls.
    @functools.lru_cache(maxsize=None)
    def unify_key(self, key, text, cursor=0):
        rules = self.grammar[key]
        # make a generator for matching rules. We dont want a list because
        # we want to be lazy and evaluate only until the first matching
        rets = (self.unify_line(rule, text, cursor) for rule in rules)
        # return the first non null (matching) rule's cursor and res
        cursor, res = next((ret for ret in rets if ret[1] is not None), (cursor, None))
        return (cursor, (key, res) if res is not None else None)

    def unify_line(self, parts, text, cursor):
        def is_symbol(v): return v[0] == '$'

        results = []
        for part in parts:
            # get the matcher function
            matcher = (self.unify_key if is_symbol(part) else self.literal_match)
            # compute the cursor, and the result from it.
            cursor, res = matcher(part, text, cursor)
            if res is None: return (cursor, None)
            results.append(res)
        return cursor, results

def main(args):
    grammar = json_grammar
    to_parse = [
        '{"text": "This is a valid JSON input"}',
        '{"text": This is NOT a valid JSON input}'
    ]

    for an_input in to_parse:
        print("Parsing", repr(an_input))
        result = PEGParser(grammar).unify_key('$START', an_input)
        print(result[1])

if __name__ == '__main__':
    main(sys.argv)
