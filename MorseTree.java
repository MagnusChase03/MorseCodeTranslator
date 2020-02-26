public class MorseTree {
	
	String data;
	MorseTree left;
	MorseTree right;
	
	MorseTree(String data) {
		
		this.data = data;
		
	}
	
	MorseTree(String data, MorseTree left, MorseTree right) {
		
		this.data = data;
		this.left = left;
		this.right = right;
		
	}
	
	void print() {
		
		print(this, 0);
		
	}
	
	void print(MorseTree node, int space) {
		
		if (node != null) {
			
			print(node.right, space + 5);
			
			String dataP = "";
			for (int i = 0; i < space; i++) {
				
				dataP +=  " "; 
				
			}
			
			System.out.println(dataP + node.data);
			
			print(node.left, space + 5);
		
		}
		
	}
	
	String translate(String morse) {
		
		String[] morseArray = morse.split(" ");
		
		String message = "";
		for (int j = 0; j < morseArray.length; j++) {
			
			char[] characters = morseArray[j].toCharArray();
			
			MorseTree curNode = this;
			for (int i = 0; i < characters.length; i++) {
				
				if (characters[i] == '.')
					curNode = curNode.left;
				
				else
					curNode = curNode.right;
				
			}
			
			message += curNode.data;
		
		}
		
		return message;
		
	}
	
	boolean contains(String data) {
		
		return contains(data, this, false);
		
	}
	
	boolean contains(String data, MorseTree node, boolean found) {
		
		if (node != null && node.data.equals(data)) {
			
			found = true;
			
		} else if (node != null) {
			
			return contains(data, node.left, found) || contains(data, node.right, found);
			
		}
		
		return found;
		
	}
	
	String encode(String message) {
		
		String m = "";
		
		for (int i = 0; i < message.length(); i++) {
			
			m += encode(message.charAt(i)) + " ";
			
		}
		
		return m;
		
	}
	
	String encode(char character) {
		
		return encode(character, this, "");
		
	}
	
	String encode(char character, MorseTree tree, String morse) {
		
		if (tree.data.equals("" + character)) {
			
			return morse;
			
		} else {
			
			if (tree.left.contains("" + character)) {
				
				return encode(character, tree.left, morse += ".");
				
			} else if (tree.right.contains("" + character)) {
				
				return encode(character, tree.right, morse += "-");
				
			}
			
			return "";
			
		}
		
	}

}
