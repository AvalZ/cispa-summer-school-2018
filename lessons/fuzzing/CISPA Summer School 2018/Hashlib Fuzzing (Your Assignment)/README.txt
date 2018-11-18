Welcome to the code samples for the "Fuzzing" lectures. These code samples were
first introduced by Andreas Zeller at the CISPA Summer School in August 2018.

Your assignment is to use the fuzzing techniques as introduced in the lecture for fuzzing a
cryptographic API, notably the Python hashlib library. The idea is to first generate a valid Python
program that exercises the hashlib functions, and then to execute this very program (and thereby
executing the hashlib functions).

The file `hashlib-fuzzer.py' already contains a template for your task; your main work is to write an appropriate grammar.  To this end, have a look at the `hashlib' documentation at

	https://docs.python.org/3/library/hashlib.html
	
Start with a grammar that generates one of the examples listed in that documentation.  Expand your grammar to cover a variety of hash algorithms, digests, inputs, and configurations, as you proceed through the documentation.

Enjoy!

Andreas Zeller <zeller@cispa.saarland>
