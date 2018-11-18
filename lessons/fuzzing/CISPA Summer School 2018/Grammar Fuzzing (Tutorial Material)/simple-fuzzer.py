#!/usr/bin/env python
# A simple fuzzer

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

def fuzzer():
    # Strings up to 1024 characters long
    string_length = int(random.random() * 1024)   
    out = ""
    for i in range(0, string_length):
        # filled with ASCII 32..128
        out += chr(int(random.random() * 96 + 32))
    return out

if __name__ == "__main__":
    print(fuzzer())