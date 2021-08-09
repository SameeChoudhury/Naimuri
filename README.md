Naiumuri Application

Hey guys, this is my Word Square Application

To be able to use this application, go into src/main/java
- Type 'javac Main.java'
- Type 'java Main'

After this, the application will run.

It will ask you for a string containing a number, n, followed by a space and a string of characters that have the length of n^2.
If the input does not satisfy the conditions, the application will ask you to re enter a value

Once the condition has been met, it will use norvigs word dictionary, taken from http://norvig.com/ngrams/enable1.txt, and the value inputted to return a list of valid words.

If the string of characters do not combine to make enough words to satisfy the creation of a word square, the application will ask you to input another value.
This is determined by looking at the number, n, and and ensuring that the amount of viable words ar atleast that amount.

Once this has been validated, it will then generate a word square.
