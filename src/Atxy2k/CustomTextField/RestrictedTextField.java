/**
 * @author Iván Ignacio Alvarado Díaz (Atxy2k)
 * @atxy2k
 * http://www.facebook.com/atxy2k
 * Email: atxy2k@gmail.com
 * 
 * Licenced By Creative Commons V3.0
 * 
 * http://serprogramador.es
 * http://ivanalvarado.net
 * 
 */
package Atxy2k.CustomTextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class RestrictedTextField implements KeyListener {

    private JTextField textField;
    private int limit = 20;
    private Document defaultDocument;
    private boolean onlyNums = false;
    private boolean onlyText = false;
    private boolean onlyAlphaNumeric = false;
    private boolean onlyCustomCharacters = false;
    private boolean acceptSpace = false;
    private String acceptCharacters = "";

    public RestrictedTextField(JTextField textField) {
        this.textField = textField;
        textField.addKeyListener(this);
        this.defaultDocument = textField.getDocument();
    }

    public RestrictedTextField(JTextField textField, String acceptCharacters) {
        this.textField = textField;
        textField.addKeyListener(this);
        this.defaultDocument = textField.getDocument();
        this.acceptCharacters = acceptCharacters.toLowerCase();
        this.setOnlyCustomCharacters(true);
    }

    public void setOnlyNums(boolean select) {
        if (select) {
            this.onlyText = false;
            this.onlyAlphaNumeric = false;
            this.onlyNums = select;
            this.onlyCustomCharacters = false;
            this.textField.setDocument(new OnlyNumsDocument());
        } else {
            restore();
        }
    }

    public void setOnlyText(boolean select) {
        if (select) {
            this.onlyNums = false;
            this.onlyAlphaNumeric = false;
            this.onlyText = select;
            this.onlyCustomCharacters = false;
            this.textField.setDocument(new OnlyTextDocument());
        } else {
            restore();
        }
    }
    
    public void setOnlyAlphaNumeric(boolean select){
        if (select) {
            this.onlyNums = false;
            this.onlyAlphaNumeric = select;
            this.onlyText = false;
            this.onlyCustomCharacters = false;
            this.textField.setDocument(new OnlyAlphanumericDocument());
        }else
        {
            restore();
        }
    }
    
    public void setOnlyCustomCharacters(boolean select){
        if (select) {
            this.onlyNums = false;
            this.onlyAlphaNumeric = false;
            this.onlyText = false;
            this.onlyCustomCharacters = select;
            this.textField.setDocument(new OnlyCustomDocument());
        }else
        {
            restore();
        }
    }
    
    public void restore() {
        this.onlyNums = false;
        this.onlyText = false;
        this.textField.setDocument(this.defaultDocument);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (this.textField.getText().length() == this.limit) {
            e.consume();
        }
    }
    
    public boolean isOnlyNums() {
        return this.onlyNums;
    }

    public boolean isOnlyText() {
        return this.onlyText;
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setAcceptSpace(boolean acceptSpace) {
        this.acceptSpace = acceptSpace;
    }

    public void setAcceptCharacters(String acceptCharacters) {
        this.acceptCharacters = acceptCharacters;
    }
    
    public class OnlyNumsDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            StringBuilder builder = new StringBuilder(str);
            str = builder.reverse().toString();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i)) || ( acceptSpace==true && Character.isWhitespace(str.charAt(i))))
                {
                    super.insertString(offs, Character.toString(str.charAt(i)), a);
                }
            }
            return;
        }
    }

    public class OnlyTextDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            StringBuilder builder = new StringBuilder(str);
            str = builder.reverse().toString();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i)) || ( acceptSpace==true && Character.isWhitespace(str.charAt(i)))) {
                    super.insertString(offs, Character.toString(str.charAt(i)), a);
                }
            }
            return;
        }
    }
    
    public class OnlyAlphanumericDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            StringBuilder builder = new StringBuilder(str);
            str = builder.reverse().toString();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetterOrDigit(str.charAt(i)) || ( acceptSpace==true && Character.isWhitespace(str.charAt(i)))) {
                    super.insertString(offs, str, a);
                }
            }
            return;
        }
    }
    
    public class OnlyCustomDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            StringBuilder builder = new StringBuilder(str);
            str = builder.reverse().toString();
            for (int i = 0; i < str.length(); i++) {
                if (acceptCharacters.contains(Character.toString(str.charAt(i)).toLowerCase()) || ( acceptSpace==true && Character.isWhitespace(str.charAt(i)))) {
                    super.insertString(offs, str, a);
                }
            }
            return;
        }
    }
    
    
}
