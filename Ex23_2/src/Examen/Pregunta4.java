package Examen;

public class Pregunta4 {
	public static int parecido(String s1, String s2) throws Exception {
		if(s1 == null || s2 == null || s2.length() != s1.length())
			throw new Exception();
		int dist = 0;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		for(int i = 0; i < s1.length(); i++)
			dist += Math.abs((int)s1.charAt(i) - (int)s2.charAt(i));
		return dist;
	}
}
