/**
 * Runtime exception when one tries to push on a stack that
 * is already full.
 * 
 * @author Richard Bryann Chua
 *
 */
public class InvalidExpressionException extends RuntimeException {
	public InvalidExpressionException(String err){
		super(err);
	}
}
