Welcome to the code samples for the "Fuzzing" lectures. These code samples were
first introduced by Andreas Zeller at the "Security Testing" course at Saarland
University in March 2017; and refined at the Halmstad Summer School on Testing
(HSST) in June 2017. Feel free to use for your own experiments; just be sure to
respect the GPL license.

To use the files, simply run them in a Python 2 or Python 3 interpreter.

* "simple-fuzzer.oy" generates a random string as output that you can feed into
  another program. To test TeX, for instance, do:

	$ python ./simple-fuzzer.py | tex

* "grammar-fuzzer.py" generates a member of the enclosed context-free grammar.

	$ python ./grammar-fuzzer.py
	
* "grammar-miner.py" observes the execution of a program (here: a URL parser)
  to derive a grammar from it:

	$ python ./grammar-miner.py

Enjoy!

Andreas Zeller <zeller@cispa.saarland>