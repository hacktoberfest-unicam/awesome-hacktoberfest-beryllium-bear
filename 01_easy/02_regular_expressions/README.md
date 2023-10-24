# Regular Expressions

A Regular Expression (or RegEx) is a pattern (or filter) that describes a set of strings that matches the pattern. 
In other words, a RegEx accepts a certain set of strings and rejects the rest.

A RegEx consists of a sequence of characters, metacharacters (such as., \d, \D, \s, \S, \w, \W), and operators (such as +, *, ?, |, ^).
They are constructed by combining many smaller sub-expressions.


In this problem, using RegEx, you have to extract all the strings from a file and exclude the tokens.
The file is in the format `<string>/<TOKEN> <string>/<TOKEN> ...`.
The TOKEN is in the form of a 2 to 4 upper-case characters long string.

## Limitations
To solve this problem, you are bound to use only the Linux/Unix Shell.

## Resources
There are many Unix command line tools that you can use to solve this problem, we suggest taking a look at [AWK](https://www.geeksforgeeks.org/awk-command-unixlinux-examples/).
But solutions with any other command line tool are also accepted.

We also suggest checking your RegEx pattern using some online resources such as [RexEx101](https://regex101.com/)
