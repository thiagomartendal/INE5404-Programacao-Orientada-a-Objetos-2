package visao;

import javax.swing.text.*;
public class Caractere extends PlainDocument{
	private static final long serialVersionUID = 1L;
	private int iMaxLength;
    
	public Caractere(int maxlen){
        super();
        iMaxLength = maxlen;
    }
    
	@Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
        if (iMaxLength <= 0){
            super.insertString(offset, str, attr);
            return;
        }
        int ilen = (getLength() + str.length());
        if(ilen <= iMaxLength){
        	super.insertString(offset, str, attr);
        }
    }
}