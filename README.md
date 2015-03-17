# RestrictedTextField
A small library to limit the content of a JTextField in Java Swing.

### General Functions

* Character Limit.
* Allow writing just numbers
* Allow writing just text
* Allow writing just alphanumeric characters
* Allow writing custom characters
* Handle permission entry blanks

### Use

Import the library within the class packages.

`import Atxy2k.CustomTextField.RestrictedTextField;`

RestrictedTextField initialize the object that allow us to manipulate a JTextField

`RestrictedTextField restricted = new RestrictedTextField(myjtextfield);`

###Methods

#### setLimit(Int number)
Assign the text field write a limit, for example, if we were using a zip code, the limit would be 5. By default the text field limit is 20 characters.
#### setOnlyNums(boolean)
Merely in the text field you can type only numbers (not including spaces), the default value is false.
#### setOnlyText(boolean)
Merely in the text field only you can type text (not including spaces), the default value is false.
#### setAcceptSpace(boolean ) 
Allows the blanks in the text field, regardless of whether any of the above methods has been executed, the default value is false.
#### setOnlyAlphanumeric(boolean ) 
Merely in the text field can be written only alphanumeric characters (not including spaces), the default value is false.
#### restore()
Resets the text field defaults
#### setOnlyCustomCharacters(boolean ) 
Merely in the text field can be written only certain characters that we provide these, also, are introduced into a text string as the second parameter of the constructor:

`r1 = new RestrictedTextField(campoTexto, "abcde");`


