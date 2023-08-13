# Detecting_languages

## This program can detect the language (english, dutch or german) using letter frequencies

When we consider multiple longer texts of the same language, the letter frequencies are pretty much the same. If we have long enough reference
texts for a number of languages, we can determine the letter frequencies in them and then detect the language of other given text. This program
takes three texts: in English, German, and Dutch (I used the text from wikipedia articles about Mr. Obama). The letter frequencies are counted
in these languages. Then, we can use some piece of text, and the program prints which of the three languages is the closest to the text.
(In my testing I have written "Hello, my name is Potato" and program prints "English").

It is possible to detect any other language. You create new CharHistogram object, use a long piece of text in that language, and add all the 
languages in an Array List. 
When detecting the language you have to compare it's letters frequency with those in Array List, and the one with
the smallest dissimilarity is returned.
 
