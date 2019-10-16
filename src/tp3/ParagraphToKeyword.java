package tp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashSet;

public class ParagraphToKeyword {

	String[] StopWords = new String[] { "a", "able", "about", "above", "abst", "accordance", "according", "accordingly",
			"across", "act", "actually", "added", "adj", "affected", "affecting", "affects", "after", "afterwards",
			"again", "against", "ah", "all", "almost", "alone", "along", "already", "also", "although", "always", "am",
			"among", "amongst", "an", "and", "announce", "another", "any", "anybody", "anyhow", "anymore", "anyone",
			"anything", "anyway", "anyways", "anywhere", "apparently", "approximately", "are", "aren", "arent", "arise",
			"around", "as", "aside", "ask", "asking", "at", "auth", "available", "away", "awfully", "b", "back", "be",
			"became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "begin", "beginning",
			"beginnings", "begins", "behind", "being", "believe", "below", "beside", "besides", "between", "beyond",
			"biol", "both", "brief", "briefly", "but", "by", "c", "ca", "came", "can", "cannot", "can't", "cause",
			"causes", "certain", "certainly", "co", "com", "come", "comes", "contain", "containing", "contains",
			"could", "couldnt", "d", "date", "did", "didn't", "different", "do", "does", "doesn't", "doing", "done",
			"don't", "down", "downwards", "due", "during", "e", "each", "ed", "edu", "effect", "eg", "eight", "eighty",
			"either", "else", "elsewhere", "end", "ending", "enough", "especially", "et", "et-al", "etc", "even",
			"ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "except", "f", "far", "few",
			"ff", "fifth", "first", "five", "fix", "followed", "following", "follows", "for", "former", "formerly",
			"forth", "found", "four", "from", "further", "furthermore", "g", "gave", "get", "gets", "getting", "give",
			"given", "gives", "giving", "go", "goes", "gone", "got", "gotten", "h", "had", "happens", "hardly", "has",
			"hasn't", "have", "haven't", "having", "he", "hed", "hence", "her", "here", "hereafter", "hereby", "herein",
			"heres", "hereupon", "hers", "herself", "hes", "hi", "hid", "him", "himself", "his", "hither", "home",
			"how", "howbeit", "however", "hundred", "i", "id", "ie", "if", "i'll", "im", "immediate", "immediately",
			"importance", "important", "in", "inc", "indeed", "index", "information", "instead", "into", "invention",
			"inward", "is", "isn't", "it", "itd", "it'll", "its", "itself", "i've", "j", "just", "k", "keep 	keeps",
			"kept", "kg", "km", "know", "known", "knows", "l", "largely", "last", "lately", "later", "latter",
			"latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "line", "little", "'ll",
			"look", "looking", "looks", "ltd", "m", "made", "mainly", "make", "makes", "many", "may", "maybe", "me",
			"mean", "means", "meantime", "meanwhile", "merely", "mg", "might", "million", "miss", "ml", "more",
			"moreover", "most", "mostly", "mr", "mrs", "much", "mug", "must", "my", "myself", "n", "na", "name",
			"namely", "nay", "nd", "near", "nearly", "necessarily", "necessary", "need", "needs", "neither", "never",
			"nevertheless", "new", "next", "nine", "ninety", "no", "nobody", "non", "none", "nonetheless", "noone",
			"nor", "normally", "nos", "not", "noted", "nothing", "now", "nowhere", "o", "obtain", "obtained",
			"obviously", "of", "off", "often", "oh", "ok", "okay", "old", "omitted", "on", "once", "one", "ones",
			"only", "onto", "or", "ord", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out",
			"outside", "over", "overall", "owing", "own", "p", "page", "pages", "part", "particular", "particularly",
			"past", "per", "perhaps", "placed", "please", "plus", "poorly", "possible", "possibly", "potentially", "pp",
			"predominantly", "present", "previously", "primarily", "probably", "promptly", "proud", "provides", "put",
			"q", "que", "quickly", "quite", "qv", "r", "ran", "rather", "rd", "re", "readily", "really", "recent",
			"recently", "ref", "refs", "regarding", "regardless", "regards", "related", "relatively", "research",
			"respectively", "resulted", "resulting", "results", "right", "run", "s", "said", "same", "saw", "say",
			"saying", "says", "sec", "section", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self",
			"selves", "sent", "seven", "several", "shall", "she", "shed", "she'll", "shes", "should", "shouldn't",
			"show", "showed", "shown", "showns", "shows", "significant", "significantly", "similar", "similarly",
			"since", "six", "slightly", "so", "some", "somebody", "somehow", "someone", "somethan", "something",
			"sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specifically", "specified", "specify",
			"specifying", "still", "stop", "strongly", "sub", "substantially", "successfully", "such", "sufficiently",
			"suggest", "sup", "sure 	t", "take", "taken", "taking", "tell", "tends", "th", "than", "thank", "thanks",
			"thanx", "that", "that'll", "thats", "that've", "the", "their", "theirs", "them", "themselves", "then",
			"thence", "there", "thereafter", "thereby", "thered", "therefore", "therein", "there'll", "thereof",
			"therere", "theres", "thereto", "thereupon", "there've", "these", "they", "theyd", "they'll", "theyre",
			"they've", "think", "this", "those", "thou", "though", "thoughh", "thousand", "throug", "through",
			"throughout", "thru", "thus", "til", "tip", "to", "together", "too", "took", "toward", "towards", "tried",
			"tries", "truly", "try", "trying", "ts", "twice", "two", "u", "un", "under", "unfortunately", "unless",
			"unlike", "unlikely", "until", "unto", "up", "upon", "ups", "us", "use", "used", "useful", "usefully",
			"usefulness", "uses", "using", "usually", "v", "value", "various", "'ve", "very", "via", "viz", "vol",
			"vols", "vs", "w", "want", "wants", "was", "wasnt", "way", "we", "wed", "welcome", "we'll", "went", "were",
			"werent", "we've", "what", "whatever", "what'll", "whats", "when", "whence", "whenever", "where",
			"whereafter", "whereas", "whereby", "wherein", "wheres", "whereupon", "wherever", "whether", "which",
			"while", "whim", "whither", "who", "whod", "whoever", "whole", "who'll", "whom", "whomever", "whos",
			"whose", "why", "widely", "willing", "wish", "with", "within", "without", "wont", "words", "world", "would",
			"wouldnt", "www", "x", "y", "yes", "yet", "you", "youd", "you'll", "your", "youre", "yours", "yourself",
			"yourselves", "you've", "z", "zero", "january", "february", "march", "april", "may", "june", "july",
			"august", "september", "october", "november", "december", "monday", "tuesday", "wednesday", "thursday",
			"friday", "saturday", "sunday" };

	String paragraph;

	HashSet<String> SW = new HashSet<String>(); // contient tout les stop words
	HashMap<String, Integer> dist = new HashMap<String, Integer>();

//	String pattern = "(?U)\\b\\p{Lu}\\p{L}*\\b";
	String pattern = "\\b[A-Z].*?\\b";

	ArrayList<String> R = new ArrayList<String>();
	ArrayList<String> onlyCaps = new ArrayList<String>();
	ArrayList<String> noStopWords = new ArrayList<String>();

	String[] S;

	public ParagraphToKeyword(String p) {
		this.paragraph = p.replace(".", "").replace(",", "");
		S = this.paragraph.split(" ");
		for (int i = 0; i < StopWords.length; i++) {
			SW.add(StopWords[i]); // initialisation du set qui contient tout les Stop words
		}

	}

	public Map<String, Integer> computeKeywords() {

		for (int i = 0; i < S.length; i++) {
			if (S[i].matches(pattern)) {
				String temp = S[i].substring(0, 1).toLowerCase() + S[i].substring(1);
				noStopWords.add(temp); // on récupère tout les mots qui commencent par une MAJ
			}
		}

		for (int i = 0; i < noStopWords.size(); i++) {
			if (!SW.contains(noStopWords.get(i))) {
				String temp = noStopWords.get(i).substring(0, 1).toUpperCase() + noStopWords.get(i).substring(1);
				R.add(temp); // On retire tout les Stop words parmis les mots qui commencent par une MAJ
			}
		}

		Map<String, Integer> results = new LinkedHashMap<String, Integer>();

		for (String s : R) { // on créé la map qui associe le mot clé à son nombre d'occurence
			if (results.get(s) != null) {
				results.put(s, results.get(s) + 1);
			} else {
				results.put(s, 1);
			}
		}

		final Map<String, Integer> sorted = results.entrySet()

				.stream()

				.sorted(Map.Entry.comparingByValue())

				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// on tri cette map en fonction des valeurs

		return sorted;

	}

	public static void main(String[] args) {

//		String p = "The Star is a movie from 1952. It was directed by Stuart Heisler. It stars Bette Davis, Sterling Hayden and Natalie Wood. Davis got a nomination for the Academy Award for Best Actress for this movie.";
//		String p = "Claracq, is a commune of the Pyrénées-Atlantiques département in the southwestern part of France.";
		String p = "The Billy Rose Art Garden Is the sculpture park designed by the Japanese-American sculptor Isamu Noguchi on the western slope of the Israel Museum in Jerusalem, Israel. The art garden is named after the impresario and lyricist Billy Rose (1899-1966). Isamu Noguchi started to plan the sculpture park from the 1960s on the slopes of the museum grounds and divided the terrain into different sections through walls made of rough unworked field stones. The artificial garden was completed in 1965.";
		ParagraphToKeyword ptkw = new ParagraphToKeyword(p);
		System.out.println("output" + " " + ptkw.computeKeywords()); // il faut maintenant implémenter des techniques de recherche côté serveur, 
		// par exemple : on chosit les n mots avec la k plus grande fréquence; On fait une n recherche avec n[i] en titre et le reste en texte 


	}

}
