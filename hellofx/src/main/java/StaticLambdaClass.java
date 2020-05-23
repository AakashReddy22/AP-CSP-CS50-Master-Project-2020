
interface StringConcat{

    public String sconcat(String a, String b);
    // Concatenating the previous strings to form the title
}


class StaticLambdaClass {
	
	
	public static class StaticlStrCat {
		
		public String returnStrCat()
		{
		 // Try making 'message' a non-static 
	    // variable, there will be compiler error 
			System.out.println( "Message from nested static class: "); 
			StringConcat s = (string1, string2) -> string1 + string2;
			String formatText = new String("Lambda Concatenation of Strings: "+s.sconcat("CS50 Master Project 2020 :  ", "World Soccer Plus"));
			
			return  formatText;
		}
	}
}

