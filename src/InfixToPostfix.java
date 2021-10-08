import oracle.jrockit.jfr.StringConstantPool;

import java.util.*;
import java.util.stream.Collectors;

public class InfixToPostfix {
	private String infix;

	private final Map<Character, Boolean> characterReplacementAvailabilityMap = new HashMap<>();

	private final List<CharacterValue> valueList = new ArrayList<>();

	private Random random;

	public InfixToPostfix(String infix){
		this.infix = infix;
		random = new Random();
		initializeCharacterReplacementAvailability();
	}

	private static int getPrecedence(char ch)
	{
		switch (ch)
		{
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
				return 2;

			case '%':
			case '^':
				return 3;
		}
		return -1;
	}

	private boolean isOperator(String token) {
		return token.equals("+") ||
				token.equals("-") ||
				token.equals("*") ||
				token.equals("/") || token.equals("%") || token.equals("^") ;
	}

	private Character getNextCharacter() {
		for( Map.Entry<Character, Boolean> availabalityMapEntry : characterReplacementAvailabilityMap.entrySet() ) {
			if( !availabalityMapEntry.getValue() ) {
				availabalityMapEntry.setValue(true);
				return availabalityMapEntry.getKey();
			}
		}

		return null;
	}

	private String replaceInput( final String input ) {

		char[] inputArray = input.toCharArray();
		for( int i = 0; i < inputArray.length; i++ ) {
//			System.out.println("input " + i + " : " + inputArray[i]);

			if( inputArray[i] == ' ' ) continue;;

			if( isOperator( inputArray[i]+"" ) ) {
				insertToList(inputArray[i], inputArray[i]+"");
			}else if( Character.isLetter( inputArray[i] ) ) {
				String variable="";
				while( i < inputArray.length && Character.isLetter(inputArray[i]) ) {
					variable += inputArray[i++];
				}

				insertToList(variable.charAt(0), variable);
				i--;
			}else if(  Character.isDigit( inputArray[i] ) ) {
				String number="";
				while( i < inputArray.length && Character.isDigit(inputArray[i]) ) {
					number += inputArray[i++];
				}
				insertToList(number.charAt(0), number);
				i--;
			}else {
				insertToList(inputArray[i], inputArray[i]+"");
			}

		}

		return valueList.stream().map(c -> c.getKey()+"").collect(Collectors.joining(""));
	}

	private void insertToList(Character key, String value ) {
		if( isOperator(key+"") ) {
			valueList.add( new CharacterValue(key, value) );
			return;
		}

		if( CharacterConstants.isEqualToLeftParen(key) || CharacterConstants.isEqualToRightParen(key) ) {
			valueList.add( new CharacterValue(key, value) );
			return;
		}
		valueList.add( new CharacterValue(getNextCharacter(), value) );
	}


	//a method to convert the infix expression to postfix expression
	//Note: this method converts the value of the instance variable infix
	public String convertToPostFix(){

		String infixValue = replaceInput(infix);
		final StringBuilder result = new StringBuilder();
		final Stack<Character> stack = new LinkedStack<>();

		for( int index = 0; index < infixValue.length(); index++ ) {
			char currentCharacter = infixValue.charAt(index);

			if (Character.isLetterOrDigit(currentCharacter)) {
				result.append(currentCharacter);
			}else if( CharacterConstants.isEqualToLeftParen( currentCharacter ) ) {
				stack.push( currentCharacter );
			}else if ( CharacterConstants.isEqualToRightParen( currentCharacter ) ) {
				while ( isStackNotEmptyAndTopElementIsNotLeftParen(stack) ) {
					result.append(stack.pop());
				}

				stack.pop();
			}else {
				while( isStackNotEmptyAndPrecedenceLevelOfCurrentIsLessOrEqualToTop( stack, currentCharacter ) ) {
					result.append(stack.pop());
				}
				stack.push(currentCharacter);
			}

		}

		while (!stack.isEmpty()){
			if( CharacterConstants.isEqualToLeftParen( stack.top() ) ) {
				throw new InvalidExpressionException( "Invalid expression" );
			}

			result.append(stack.pop());
		}

		
		return replaceBack(result.toString());
	}

	private String replaceBack( final String result ) {
		final List<String> finalResult = new ArrayList<>();
		for( char character : result.toCharArray() ) {
			finalResult.add( replaceFromList(character));
		}

		return String.join(" ", finalResult);
	}

	private String replaceFromList( final Character character ) {
		for( CharacterValue characterValue : valueList ) {
			if( characterValue.getKey().equals(character) ) return characterValue.getValue();
		}
		return "";
	}

	private boolean isStackNotEmptyAndPrecedenceLevelOfCurrentIsLessOrEqualToTop( final Stack<Character> stack, final Character currentCharacter ) {
		return !stack.isEmpty() && getPrecedence( currentCharacter ) <= getPrecedence( stack.top() );
	}

	private boolean isStackNotEmptyAndTopElementIsNotLeftParen( final Stack<Character> stack ) {
		return !stack.isEmpty() && !CharacterConstants.isEqualToLeftParen(stack.top()) ;
	}


	private void initializeCharacterReplacementAvailability() {
		characterReplacementAvailabilityMap.put('A', false);
		characterReplacementAvailabilityMap.put('B', false);
		characterReplacementAvailabilityMap.put('C', false);
		characterReplacementAvailabilityMap.put('D', false);
		characterReplacementAvailabilityMap.put('E', false);
		characterReplacementAvailabilityMap.put('F', false);
		characterReplacementAvailabilityMap.put('G', false);
		characterReplacementAvailabilityMap.put('H', false);
		characterReplacementAvailabilityMap.put('I', false);
		characterReplacementAvailabilityMap.put('J', false);
		characterReplacementAvailabilityMap.put('K', false);
		characterReplacementAvailabilityMap.put('L', false);
		characterReplacementAvailabilityMap.put('M', false);
		characterReplacementAvailabilityMap.put('N', false);
		characterReplacementAvailabilityMap.put('O', false);
		characterReplacementAvailabilityMap.put('P', false);
		characterReplacementAvailabilityMap.put('Q', false);
		characterReplacementAvailabilityMap.put('R', false);
		characterReplacementAvailabilityMap.put('S', false);
		characterReplacementAvailabilityMap.put('T', false);
		characterReplacementAvailabilityMap.put('U', false);
		characterReplacementAvailabilityMap.put('V', false);
		characterReplacementAvailabilityMap.put('W', false);
		characterReplacementAvailabilityMap.put('X', false);
		characterReplacementAvailabilityMap.put('Y', false);
		characterReplacementAvailabilityMap.put('Z', false);
		characterReplacementAvailabilityMap.put('a', false);
		characterReplacementAvailabilityMap.put('b', false);
	}
}
