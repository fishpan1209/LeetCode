public class MisspelledgWord {
		
	//----------------------------//
		public static String find3(HashSet<String> set, String str){
			// build trietree
			TrieNode root = new TrieNode();
			for(String word : set){
				Map<Character, TrieNode> children = root.children;
				TrieNode t = null;
				for(int i = 0; i < word.length(); i++){
					char c = word.charAt(i);
					if(children.containsKey(c)){
						t = children.get(c);
					}else{
						t = new TrieNode(c);
						children.put(c,t);
					}

					children = t.children;

					if(i == word.length()-1){
						t.isWord = true; 
					}
				}
			}
			String ans = searchNode(root, str, 1).toString();
			return ans;
		}
		
		
		public static StringBuilder searchNode(TrieNode root, String str, int k){
			Map<Character, TrieNode> children = root.children;
			TrieNode t = null;
			StringBuilder ans = new StringBuilder();
			for(int i = 0; i < str.length(); i++){
				char c = str.charAt(i);
				if(children.containsKey(c)){
					t = children.get(c);
					children = t.children;
					ans.append(c);
				}else if(k ==1){
					k--;
					for(Character newChar : children.keySet()){
						ans.append(newChar);
						String newStr = str.substring(i+1);
						TrieNode newT = children.get(newChar);
						StringBuilder newAns = searchNode(newT, newStr,0);
						if(newAns!=null){
							return ans.append(newAns);

						}else{
							return null; 
						}
					}
				}else{
					return null;
				}
			}

			return ans; 
		}
		
		
		
		
		public static void main(String[] args){
			HashSet<String> set = new HashSet<String>();
			set.add("google");
			set.add("apple");
			set.add("orange");
			System.out.print(find3(set, "gookle"));
		}

	}
