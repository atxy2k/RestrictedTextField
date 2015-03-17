# RestrictedTextField
Una pequeña libreria para limitar el contenido de un JTextField en Java Swing.

### Funciones Generales

* Limite de caracteres.
* Permitir la escritura de solo números
* Permitir la escritura de solo texto
* Manipular el permiso de ingreso de espacios en blanco
* Restringir el jTextField al ingreso de caracteres alfanumericos.
* Caracteres personalizados, permite enviar un arreglo de caracteres para indicar cuales serán aceptados en el campo de texto.

### Uso

Primero que nada es necesario importar la libreria dentro de los paquetes de la clase.

`import Atxy2k.CustomTextField.RestrictedTextField;`

Posteriormente inicializamos el objeto RestrictedTextField que nos permitirá manipular un objeto JTextField

`RestrictedTextField restricted = new RestrictedTextField(myjtextfield);`

###Metodos

#### setLimit(Int number)
Asigna al campo de texto un limite de escritura, por ejemplo, si lo estuvieramos utilizando para un código postal, el limite sería 5. Por defecto el límite del campo de texto es 20 caracteres.
#### setOnlyNums(boolean)
Limita a que en el campo de texto solo se pueda escribir numeros (no incluye espacios en blanco), por defecto el valor es false.
#### setOnlyText(boolean)
Limita a que en el campo de texto solo se pueda escribir texto (no incluye espacios en blanco), por defecto el valor es false.
#### setAcceptSpace(boolean ) 
Permite los espacios en blanco en el campo de texto, sin importar si alguno de los metodos anteriores se ha ejecutado, por defecto el valor es false.
#### setOnlyAlphanumeric
Limita a que en el campo de texto solo se pueda escribir caracteres alfanumericos (no incluye espacios en blanco), por defecto el valor es false.
#### restore
Restablece los valores del campo de texto a los valores por defecto
#### setOnlyCustomCharacters
Limita a que en el campo de texto solo se pueda escribir ciertos caracteres que proporcionemos, estos, así mismo, son introducidos en una cadena de texto como segundo parametro del constructor:

`public class PruebaRestrictedTextField extends JFrame{
    
    JTextField campoTexto;
    RestrictedTextField r1;
    
    public PruebaRestrictedTextField()
    {
        Container contain = getContentPane();
        contain.setLayout(new FlowLayout());
        campoTexto = new JTextField(10);
        contain.add(campoTexto);
        //Inicializando el RestrictedTextField
        r1 = new RestrictedTextField(campoTexto, "abcde");
        r1.setLimit(10);
    }
    
    public static void main(String[] args) {
        PruebaRestrictedTextField window = new PruebaRestrictedTextField();
        window.setSize(new Dimension(300, 200));
        window.setVisible(true);
    }
    
}`


