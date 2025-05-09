import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class LimitJTextField extends PlainDocument 
{
   /**
	 * 
	 */
	private static final long serialVersionUID = -6023962288315644423L;
private int max;
   LimitJTextField(int max) {
      super();
      this.max = max;
   }
   public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
      if (text == null)
         return;
      if ((getLength() + text.length()) <= max) {
         super.insertString(offset, text, attr);
      }
   }
}